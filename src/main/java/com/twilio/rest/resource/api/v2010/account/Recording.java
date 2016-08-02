/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.resource.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.rest.converter.DateConverter;
import com.twilio.rest.deleter.api.v2010.account.RecordingDeleter;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.fetcher.api.v2010.account.RecordingFetcher;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.reader.api.v2010.account.RecordingReader;
import com.twilio.rest.resource.Resource;
import com.twilio.rest.resource.RestException;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recording extends Resource {
    private static final long serialVersionUID = 232068402359085L;

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param sid Fetch by unique recording Sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetch(final String accountSid, 
                                         final String sid) {
        return new RecordingFetcher(accountSid, sid);
    }

    /**
     * Create a RecordingFetcher to execute fetch.
     * 
     * @param sid Fetch by unique recording Sid
     * @return RecordingFetcher capable of executing the fetch
     */
    public static RecordingFetcher fetch(final String sid) {
        return new RecordingFetcher(sid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param accountSid The account_sid
     * @param sid Delete by unique recording Sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter delete(final String accountSid, 
                                          final String sid) {
        return new RecordingDeleter(accountSid, sid);
    }

    /**
     * Create a RecordingDeleter to execute delete.
     * 
     * @param sid Delete by unique recording Sid
     * @return RecordingDeleter capable of executing the delete
     */
    public static RecordingDeleter delete(final String sid) {
        return new RecordingDeleter(sid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader read(final String accountSid) {
        return new RecordingReader(accountSid);
    }

    /**
     * Create a RecordingReader to execute read.
     * 
     * @return RecordingReader capable of executing the read
     */
    public static RecordingReader read() {
        return new RecordingReader();
    }

    /**
     * Converts a JSON String into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Recording object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Recording object represented by the provided JSON
     */
    public static Recording fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Recording.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String callSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String duration;
    private final String sid;
    private final String uri;

    @JsonCreator
    private Recording(@JsonProperty("account_sid")
                      final String accountSid, 
                      @JsonProperty("api_version")
                      final String apiVersion, 
                      @JsonProperty("call_sid")
                      final String callSid, 
                      @JsonProperty("date_created")
                      final String dateCreated, 
                      @JsonProperty("date_updated")
                      final String dateUpdated, 
                      @JsonProperty("duration")
                      final String duration, 
                      @JsonProperty("sid")
                      final String sid, 
                      @JsonProperty("uri")
                      final String uri) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.callSid = callSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.duration = duration;
        this.sid = sid;
        this.uri = uri;
    }

    /**
     * Returns The The unique sid that identifies this account.
     * 
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The version of the API in use during the recording..
     * 
     * @return The version of the API in use during the recording.
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The call during which the recording was made..
     * 
     * @return The call during which the recording was made.
     */
    public final String getCallSid() {
        return this.callSid;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The length of the recording, in seconds..
     * 
     * @return The length of the recording, in seconds.
     */
    public final String getDuration() {
        return this.duration;
    }

    /**
     * Returns The A string that uniquely identifies this recording.
     * 
     * @return A string that uniquely identifies this recording
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Recording other = (Recording) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(callSid, other.callSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            callSid,
                            dateCreated,
                            dateUpdated,
                            duration,
                            sid,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("callSid", callSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("duration", duration)
                          .add("sid", sid)
                          .add("uri", uri)
                          .toString();
    }
}