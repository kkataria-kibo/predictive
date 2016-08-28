package com.scuti.predictive.service;

/**
 * Created by kkataria on 8/28/2016.
 */

import com.jcraft.jsch.*;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardCopyOption;
import java.util.*;


@Slf4j
@Service
public class SFTPService {

    public static final int SFTP_PORT = 22;
    public static final String HOST_NAME = "sftp.scuticommerce.com";
    public static final String PASS = "Devil@707";
    public static final String SFTPUSERNAME = "sftpusername";


    public boolean uploadString(String input, String fileName, Integer orgID) throws Exception {

        try (InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))) {

            return uploadStream(stream, fileName, (long) input.getBytes(StandardCharsets.UTF_8).length, orgID);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean uploadFile(File file, String fileName, Integer orgID) throws Exception {

        try (InputStream stream = new FileInputStream(file)) {

            return uploadStream(stream, fileName, file.length(), orgID);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public boolean uploadStream(InputStream stream, String fileName, Long streamSize, Integer orgID) throws Exception {

        boolean success = false;
        Session session = null;
        Channel channel = null;

        try {

            JSch jsch = new JSch();

            //Ensure we are connecting to the same host.
            jsch.setKnownHosts(new ClassPathResource("known_hosts").getInputStream());


            session = jsch.getSession(SFTPUSERNAME, HOST_NAME, SFTP_PORT);

            session.setPassword("Devil@707");

            Properties config = new Properties();
            session.setConfig(config);

            session.connect(Integer.parseInt("30000"));

            channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            if (sftpChannel != null) {

                if (!StringUtils.isEmpty("/download")) {
                    sftpChannel.cd("productFiles");
                }

                long startTime = System.currentTimeMillis();

                sftpChannel.put(stream, fileName, new FtpUploadMonitor(streamSize));

                long endTime = System.currentTimeMillis();

                log.info("Uploaded file [{}] to host [{}] in {} milliseconds",
                        fileName,
                        HOST_NAME,
                        endTime - startTime);

                success = true;
            }

        } catch (Exception ex) {

            log.error(String.format("Error connection to SFTP "), ex);

        } finally {

            if (session != null) {
                if (channel != null) {
                    channel.disconnect();
                }
                session.disconnect();
            }
        }
        return success;
    }

    public boolean downloadFile(Integer orgID) throws Exception {

        boolean success = false;
        Session session = null;
        Channel channel = null;

        try {

            JSch jsch = new JSch();

            //Ensure we are connecting to the same host.
            jsch.setKnownHosts(new ClassPathResource("known_hosts").getInputStream());

            session = jsch.getSession(SFTPUSERNAME,
                    HOST_NAME, SFTP_PORT);

            session.setPassword(PASS);

            Properties config = new Properties();
            session.setConfig(config);

            session.connect(Integer.parseInt("30000"));

            channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;

            if (sftpChannel != null) {

                if (!StringUtils.isEmpty("downloads")) {

                    sftpChannel.cd("products");

                    String fileName = "productImport.csv";

                    long startTime = System.currentTimeMillis();

                    InputStream stream = sftpChannel.get(fileName);

                    File targetFile = File.createTempFile("productImport" + orgID, "csv");

                    targetFile.deleteOnExit();

                    java.nio.file.Files.copy(
                            stream,
                            targetFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING);

                    CSVParser parser = CSVParser.parse(targetFile, Charset.forName(StandardCharsets.UTF_8.name()), CSVFormat.DEFAULT.withHeader());

                    IOUtils.closeQuietly(stream);
                    //just print for now...
                    printdata(parser);

                    //remove file from SFTP location once everything is done.
                    sftpChannel.rm(fileName);

                    long endTime = System.currentTimeMillis();

                    log.info("Downloaded and imported file [{}] from host [{}] in {} milliseconds",
                            fileName,
                            HOST_NAME,
                            endTime - startTime);

                    success = true;
                }
            }

        } catch (Exception ex) {

            log.error(String.format("Issue importing file from SFTP "), ex);

        } finally {

            if (session != null) {
                if (channel != null) {
                    channel.disconnect();
                }
                session.disconnect();
            }
        }
        return success;
    }

    /**
     * A monitor that will report some progress on the upload of a file so we can investigate any issues.
     */
    public class FtpUploadMonitor implements SftpProgressMonitor {

        String filename;
        Long lastCount = 0L;
        Long streamSize = -1L;

        public FtpUploadMonitor(Long streamSize) {
            if (streamSize != null) {
                this.streamSize = streamSize;
            }
        }

        @Override
        public void init(int op, String src, String dest, long max) {
            filename = dest;

            if (op != SftpProgressMonitor.PUT) {
                throw new RuntimeException("Unexpected op code!");
            }

            if (streamSize < 0) {
                log.info("Starting PUT for file [{}] with unknown size", dest);
            } else {
                log.info("Starting PUT for file [{}] with size {}", dest, streamSize);
            }
        }

        @Override
        public boolean count(long count) {
            lastCount = count;
            return true;
        }

        @Override
        public void end() {
            if (lastCount.equals(streamSize)) {
                log.info("Upload for file [{}] finished after {}/{} bytes transferred", filename, lastCount, streamSize);
            } else {
                log.error("Upload for file [{}] finished prematurely with {}/{} bytes transferred", filename, lastCount,
                        streamSize);
            }
        }
    }

    public void printdata(CSVParser parser)
            throws Exception {

        Set<String> headers = parser.getHeaderMap().keySet();

        int lineNumber = 1;

        for (CSVRecord line : parser) {
            lineNumber++;
            String dataHeader1 = StringUtils.trim(line.get("Header1"));
            log.debug("PARSING CSV FILE...." + dataHeader1);

        }

    }
}
