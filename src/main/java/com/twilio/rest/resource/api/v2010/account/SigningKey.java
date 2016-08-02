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
import com.twilio.rest.deleter.api.v2010.account.SigningKeyDeleter;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.fetcher.api.v2010.account.SigningKeyFetcher;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.reader.api.v2010.account.SigningKeyReader;
import com.twilio.rest.resource.Resource;
import com.twilio.rest.resource.RestException;
import com.twilio.rest.updater.api.v2010.account.SigningKeyUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SigningKey extends Resource {
    private static final long serialVersionUID = 96350302686036L;

    /**
     * Create a SigningKeyFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return SigningKeyFetcher capable of executing the fetch
     */
    public static SigningKeyFetcher fetch(final String accountSid, 
                                          final String sid) {
        return new SigningKeyFetcher(accountSid, sid);
    }

    /**
     * Create a SigningKeyFetcher to execute fetch.
     * 
     * @param sid The sid
     * @return SigningKeyFetcher capable of executing the fetch
     */
    public static SigningKeyFetcher fetch(final String sid) {
        return new SigningKeyFetcher(sid);
    }

    /**
     * Create a SigningKeyUpdater to execute update.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return SigningKeyUpdater capable of executing the update
     */
    public static SigningKeyUpdater update(final String accountSid, 
                                           final String sid) {
        return new SigningKeyUpdater(accountSid, sid);
    }

    /**
     * Create a SigningKeyUpdater to execute update.
     * 
     * @param sid The sid
     * @return SigningKeyUpdater capable of executing the update
     */
    public static SigningKeyUpdater update(final String sid) {
        return new SigningKeyUpdater(sid);
    }

    /**
     * Create a SigningKeyDeleter to execute delete.
     * 
     * @param accountSid The account_sid
     * @param sid The sid
     * @return SigningKeyDeleter capable of executing the delete
     */
    public static SigningKeyDeleter delete(final String accountSid, 
                                           final String sid) {
        return new SigningKeyDeleter(accountSid, sid);
    }

    /**
     * Create a SigningKeyDeleter to execute delete.
     * 
     * @param sid The sid
     * @return SigningKeyDeleter capable of executing the delete
     */
    public static SigningKeyDeleter delete(final String sid) {
        return new SigningKeyDeleter(sid);
    }

    /**
     * Create a SigningKeyReader to execute read.
     * 
     * @param accountSid The account_sid
     * @return SigningKeyReader capable of executing the read
     */
    public static SigningKeyReader read(final String accountSid) {
        return new SigningKeyReader(accountSid);
    }

    /**
     * Create a SigningKeyReader to execute read.
     * 
     * @return SigningKeyReader capable of executing the read
     */
    public static SigningKeyReader read() {
        return new SigningKeyReader();
    }

    /**
     * Converts a JSON String into a SigningKey object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SigningKey object represented by the provided JSON
     */
    public static SigningKey fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SigningKey.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SigningKey object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SigningKey object represented by the provided JSON
     */
    public static SigningKey fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SigningKey.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;

    @JsonCreator
    private SigningKey(@JsonProperty("sid")
                       final String sid, 
                       @JsonProperty("friendly_name")
                       final String friendlyName, 
                       @JsonProperty("date_created")
                       final String dateCreated, 
                       @JsonProperty("date_updated")
                       final String dateUpdated) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        SigningKey other = (SigningKey) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            friendlyName,
                            dateCreated,
                            dateUpdated);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .toString();
    }
}