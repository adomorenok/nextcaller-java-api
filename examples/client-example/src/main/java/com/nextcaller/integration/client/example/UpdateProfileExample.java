package com.nextcaller.integration.client.example;

import com.nextcaller.integration.client.NextCallerClient;
import com.nextcaller.integration.exceptions.AuthenticationException;
import com.nextcaller.integration.exceptions.HttpException;
import com.nextcaller.integration.exceptions.ValidateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateProfileExample {

    private static final Logger logger = LoggerFactory.getLogger(UpdateProfileExample.class);
    
    private static final String username = "XXXXX";
    private static final String password = "XXXXX";
    private static final boolean sandbox = true;
    private static final String profileId = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    public static void main(String[] args) {
        logger.info("Run update by profile id");

        NextCallerClient client = new NextCallerClient(username, password, sandbox);

        try {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("email", "test@test.com");

            client.updateByProfileId(profileId, data, true);

            logger.info("Update user success");
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