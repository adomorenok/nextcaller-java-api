package com.nextcaller.integration.client.example;

import com.nextcaller.integration.client.NextCallerClient;
import com.nextcaller.integration.exceptions.AuthenticationException;
import com.nextcaller.integration.exceptions.HttpException;
import com.nextcaller.integration.exceptions.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

public class GetProfileByIdExample {

    private static final Logger logger = LoggerFactory.getLogger(GetProfileByIdExample.class);

    private static final String username = "XXXXX";
    private static final String password = "XXXXX";
    private static final boolean sandbox = true;
    private static final String profileId = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public static void main(String[] args) {
        logger.info("Run get by profile id");

        NextCallerClient client = new NextCallerClient(username, password, sandbox);

        try {
            Map<String, Object> profile = client.getByProfileId(profileId, true);

            System.out.println("first name: " + profile.get("first_name"));
            System.out.println("middle name: " + profile.get("middle_name"));
            System.out.println("last name: " + profile.get("last_name"));
            System.out.println("email: " + profile.get("email"));
        } catch (HttpException e) {
            logger.error("HttpException: http status code {}. response code {}. response message: {}.",
                    e.getHttpStatusCode(), e.getErrorMessage().getCode(), e.getErrorMessage().getMessage());
        } catch (ValidateException e) {
            logger.error("ValidateException: {}", e.getMessage());
        } catch (AuthenticationException e) {
            logger.error("AuthenticationException({}): {}", e.getErrorMessage().getCode(), e.getErrorMessage().getMessage());
        } catch (IOException e) {
            logger.error("IOException: {}", e.getMessage());
        }
    }

}