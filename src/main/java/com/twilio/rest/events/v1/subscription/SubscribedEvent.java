/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.events.v1.subscription;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class SubscribedEvent extends Resource {
    private static final long serialVersionUID = 128787608390551L;

    /**
     * Create a SubscribedEventReader to execute read.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @return SubscribedEventReader capable of executing the read
     */
    public static SubscribedEventReader reader(final String pathSubscriptionSid) {
        return new SubscribedEventReader(pathSubscriptionSid);
    }

    /**
     * Create a SubscribedEventCreator to execute create.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @param type Type of event being subscribed to.
     * @return SubscribedEventCreator capable of executing the create
     */
    public static SubscribedEventCreator creator(final String pathSubscriptionSid,
                                                 final String type) {
        return new SubscribedEventCreator(pathSubscriptionSid, type);
    }

    /**
     * Create a SubscribedEventFetcher to execute fetch.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @param pathType Type of event being subscribed to.
     * @return SubscribedEventFetcher capable of executing the fetch
     */
    public static SubscribedEventFetcher fetcher(final String pathSubscriptionSid,
                                                 final String pathType) {
        return new SubscribedEventFetcher(pathSubscriptionSid, pathType);
    }

    /**
     * Create a SubscribedEventUpdater to execute update.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @param pathType Type of event being subscribed to.
     * @return SubscribedEventUpdater capable of executing the update
     */
    public static SubscribedEventUpdater updater(final String pathSubscriptionSid,
                                                 final String pathType) {
        return new SubscribedEventUpdater(pathSubscriptionSid, pathType);
    }

    /**
     * Create a SubscribedEventDeleter to execute delete.
     *
     * @param pathSubscriptionSid Subscription SID.
     * @param pathType Type of event being subscribed to.
     * @return SubscribedEventDeleter capable of executing the delete
     */
    public static SubscribedEventDeleter deleter(final String pathSubscriptionSid,
                                                 final String pathType) {
        return new SubscribedEventDeleter(pathSubscriptionSid, pathType);
    }

    /**
     * Converts a JSON String into a SubscribedEvent object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return SubscribedEvent object represented by the provided JSON
     */
    public static SubscribedEvent fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SubscribedEvent.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a SubscribedEvent object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return SubscribedEvent object represented by the provided JSON
     */
    public static SubscribedEvent fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, SubscribedEvent.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String type;
    private final Integer version;
    private final String subscriptionSid;
    private final URI url;

    @JsonCreator
    private SubscribedEvent(@JsonProperty("account_sid")
                            final String accountSid,
                            @JsonProperty("type")
                            final String type,
                            @JsonProperty("version")
                            final Integer version,
                            @JsonProperty("subscription_sid")
                            final String subscriptionSid,
                            @JsonProperty("url")
                            final URI url) {
        this.accountSid = accountSid;
        this.type = type;
        this.version = version;
        this.subscriptionSid = subscriptionSid;
        this.url = url;
    }

    /**
     * Returns Account SID..
     *
     * @return Account SID.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns Type of event being subscribed to..
     *
     * @return Type of event being subscribed to.
     */
    public final String getType() {
        return this.type;
    }

    /**
     * Returns The schema version that the subscription should use..
     *
     * @return The schema version that the subscription should use.
     */
    public final Integer getVersion() {
        return this.version;
    }

    /**
     * Returns Subscription SID..
     *
     * @return Subscription SID.
     */
    public final String getSubscriptionSid() {
        return this.subscriptionSid;
    }

    /**
     * Returns The URL of this resource..
     *
     * @return The URL of this resource.
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SubscribedEvent other = (SubscribedEvent) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(type, other.type) &&
               Objects.equals(version, other.version) &&
               Objects.equals(subscriptionSid, other.subscriptionSid) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            type,
                            version,
                            subscriptionSid,
                            url);
    }
}