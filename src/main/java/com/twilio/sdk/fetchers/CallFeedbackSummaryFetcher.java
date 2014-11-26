package com.twilio.sdk.fetchers;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.CallFeedbackSummary;
import com.twilio.sdk.resources.RestException;

public class CallFeedbackSummaryFetcher extends Fetcher<CallFeedbackSummary> {

    private final String sid;

    public CallFeedbackSummaryFetcher(final String sid) {
        this.sid = sid;
    }

    @Override
    public CallFeedbackSummary execute(final TwilioRestClient client) {
        Request request = new Request(HttpMethod.GET, "/Accounts/{AccountSid}/Calls/FeedbackSummary/" + sid + ".json");
        Response response = client.request(request);

        if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            throw new ApiException(restException.getMessage(), restException.getCode(), restException.getMoreInfo(),
                                   restException.getStatus(), null);
        }

        return CallFeedbackSummary.fromJson(response.getStream(), client.getObjectMapper());
    }
}