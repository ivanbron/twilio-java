/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.reader.api.v2010.account.sms;

import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.reader.Reader;
import com.twilio.rest.resource.Page;
import com.twilio.rest.resource.ResourceSet;
import com.twilio.rest.resource.RestException;
import com.twilio.rest.resource.api.v2010.account.sms.ShortCode;

public class ShortCodeReader extends Reader<ShortCode> {
    private String accountSid;
    private String friendlyName;
    private String shortCode;

    /**
     * Construct a new ShortCodeReader.
     */
    public ShortCodeReader() {
    }

    /**
     * Construct a new ShortCodeReader.
     * 
     * @param accountSid The account_sid
     */
    public ShortCodeReader(final String accountSid) {
        this.accountSid = accountSid;
    }

    /**
     * Only show the ShortCode resources with friendly names that exactly match this
     * name.
     * 
     * @param friendlyName Filter by friendly name
     * @return this
     */
    public ShortCodeReader byFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Only show the ShortCode resources that match this pattern. You can specify
     * partial numbers and use '*' as a wildcard for any digit.
     * 
     * @param shortCode Filter by ShortCode
     * @return this
     */
    public ShortCodeReader byShortCode(final String shortCode) {
        this.shortCode = shortCode;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return ShortCode ResourceSet
     */
    @Override
    public ResourceSet<ShortCode> execute(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage());
    }

    /**
     * Make the request to the Twilio API to perform the read.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return ShortCode ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<ShortCode> firstPage(final TwilioRestClient client) {
        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.accountSid + "/SMS/ShortCodes.json",
            client.getRegion()
        );
        
        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     * 
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<ShortCode> nextPage(final Page<ShortCode> page, 
                                    final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                TwilioRestClient.Domains.API.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of ShortCode Resources for a given request.
     * 
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<ShortCode> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("ShortCode read failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Page.fromJson(
            "short_codes",
            response.getContent(),
            ShortCode.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     * 
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (friendlyName != null) {
            request.addQueryParam("FriendlyName", friendlyName);
        }
        
        if (shortCode != null) {
            request.addQueryParam("ShortCode", shortCode);
        }
        
        request.addQueryParam("PageSize", Integer.toString(getPageSize()));
    }
}