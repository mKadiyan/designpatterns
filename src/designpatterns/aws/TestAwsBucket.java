/*
 * Copyright (c) Mehar  2016 ALL RIGHTS RESERVED.
 *
 * 
 */

package designpatterns.aws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.util.UUID;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class TestAwsBucket {
	private static final String AMAZON_ACCESS_KEY = "AKIAI7K7APMOIAMQXWAA";
	private static final String AMAZON_SECRET_KEY = "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";
	private static final String S3_BUCKET_NAME = "tgts";

	public static void main(String[] args) {
		ConsoleAppender console = new ConsoleAppender();
		console.setWriter(new OutputStreamWriter(System.out));
		console.setLayout(new PatternLayout("%-5p [%t]: %m%n"));
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.ALL);
		root.addAppender(console);
		
		
		
		
		BasicAWSCredentials awsCredentials = new BasicAWSCredentials(AMAZON_ACCESS_KEY, AMAZON_SECRET_KEY);
		ClientConfiguration clientConfiguration = new ClientConfiguration();
		clientConfiguration.setMaxConnections(100);
		clientConfiguration.setConnectionTimeout(50000);
		clientConfiguration.setSocketTimeout(50000);
		clientConfiguration.setMaxErrorRetry(1);
		
		clientConfiguration.setProtocol(Protocol.HTTPS);
		clientConfiguration.setProxyHost("132.186.198.2");
		clientConfiguration.setProxyPort(9090);
		clientConfiguration.setProxyUsername("ic013367");
		clientConfiguration.setProxyPassword("Siemens12345678");
		
		
		AmazonS3Client s3client = new AmazonS3Client(awsCredentials,clientConfiguration);
//		s3client.setEndpoint("tgts.s3-website-ap-southeast-1.amazonaws.com");
		File file = new File("C:\\Users\\ic013367\\Downloads\\a1.jpg");

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectMetadata om = new ObjectMetadata();
			om.setContentLength(file.length());
			String ext = UUID.randomUUID().toString();
			String keyName = ext + '.' + getFileExtension(file);

			s3client.putObject(new PutObjectRequest(S3_BUCKET_NAME, keyName, fis, om));
			s3client.setObjectAcl(S3_BUCKET_NAME, keyName, CannedAccessControlList.PublicRead);
			System.err.println(s3client.getUrl(S3_BUCKET_NAME, keyName));

		} catch (AmazonServiceException ase) {
			System.out.println(ase);
			ase.printStackTrace();

		} catch (AmazonClientException ace) {
			System.out.println(ace);
			ace.printStackTrace();

		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();

		}
	}
	private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}

/*
 * Copyright (c) Mehar 2016 ALL RIGHTS RESERVED
 *
 */
