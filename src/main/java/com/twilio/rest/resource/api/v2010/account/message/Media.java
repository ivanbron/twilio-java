/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.resource.api.v2010.account.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.rest.converter.DateConverter;
import com.twilio.rest.deleter.api.v2010.account.message.MediaDeleter;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.fetcher.api.v2010.account.message.MediaFetcher;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.reader.api.v2010.account.message.MediaReader;
import com.twilio.rest.resource.Resource;
import com.twilio.rest.resource.RestException;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Media extends Resource {
    private static final long serialVersionUID = 138990472819672L;

    /**
     * Create a MediaDeleter to execute delete.
     * 
     * @param accountSid The account_sid
     * @param messageSid The message_sid
     * @param sid Delete by unique media Sid
     * @return MediaDeleter capable of executing the delete
     */
    public static MediaDeleter delete(final String accountSid, 
                                      final String messageSid, 
                                      final String sid) {
        return new MediaDeleter(accountSid, messageSid, sid);
    }

    /**
     * Create a MediaDeleter to execute delete.
     * 
     * @param messageSid The message_sid
     * @param sid Delete by unique media Sid
     * @return MediaDeleter capable of executing the delete
     */
    public static MediaDeleter delete(final String messageSid, 
                                      final String sid) {
        return new MediaDeleter(messageSid, sid);
    }

    /**
     * Create a MediaFetcher to execute fetch.
     * 
     * @param accountSid The account_sid
     * @param messageSid The message_sid
     * @param sid Fetch by unique media Sid
     * @return MediaFetcher capable of executing the fetch
     */
    public static MediaFetcher fetch(final String accountSid, 
                                     final String messageSid, 
                                     final String sid) {
        return new MediaFetcher(accountSid, messageSid, sid);
    }

    /**
     * Create a MediaFetcher to execute fetch.
     * 
     * @param messageSid The message_sid
     * @param sid Fetch by unique media Sid
     * @return MediaFetcher capable of executing the fetch
     */
    public static MediaFetcher fetch(final String messageSid, 
                                     final String sid) {
        return new MediaFetcher(messageSid, sid);
    }

    /**
     * Create a MediaReader to execute read.
     * 
     * @param accountSid The account_sid
     * @param messageSid The message_sid
     * @return MediaReader capable of executing the read
     */
    public static MediaReader read(final String accountSid, 
                                   final String messageSid) {
        return new MediaReader(accountSid, messageSid);
    }

    /**
     * Create a MediaReader to execute read.
     * 
     * @param messageSid The message_sid
     * @return MediaReader capable of executing the read
     */
    public static MediaReader read(final String messageSid) {
        return new MediaReader(messageSid);
    }

    /**
     * Converts a JSON String into a Media object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Media object represented by the provided JSON
     */
    public static Media fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Media.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Media object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Media object represented by the provided JSON
     */
    public static Media fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Media.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String contentType;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String parentSid;
    private final String sid;
    private final String uri;

    @JsonCreator
    private Media(@JsonProperty("account_sid")
                  final String accountSid, 
                  @JsonProperty("content_type")
                  final String contentType, 
                  @JsonProperty("date_created")
                  final String dateCreated, 
                  @JsonProperty("date_updated")
                  final String dateUpdated, 
                  @JsonProperty("parent_sid")
                  final String parentSid, 
                  @JsonProperty("sid")
                  final String sid, 
                  @JsonProperty("uri")
                  final String uri) {
        this.accountSid = accountSid;
        this.contentType = contentType;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.parentSid = parentSid;
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
     * Returns The The default mime-type of the media.
     * 
     * @return The default mime-type of the media
     */
    public final String getContentType() {
        return this.contentType;
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
     * Returns The The unique id of the resource that created the media..
     * 
     * @return The unique id of the resource that created the media.
     */
    public final String getParentSid() {
        return this.parentSid;
    }

    /**
     * Returns The A string that uniquely identifies this media.
     * 
     * @return A string that uniquely identifies this media
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
        
        Media other = (Media) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(contentType, other.contentType) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(parentSid, other.parentSid) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            contentType,
                            dateCreated,
                            dateUpdated,
                            parentSid,
                            sid,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("contentType", contentType)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("parentSid", parentSid)
                          .add("sid", sid)
                          .add("uri", uri)
                          .toString();
    }
}