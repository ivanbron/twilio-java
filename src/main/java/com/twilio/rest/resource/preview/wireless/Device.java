/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.resource.preview.wireless;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.rest.converter.DateConverter;
import com.twilio.rest.creator.preview.wireless.DeviceCreator;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.fetcher.preview.wireless.DeviceFetcher;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.reader.preview.wireless.DeviceReader;
import com.twilio.rest.resource.Resource;
import com.twilio.rest.resource.RestException;
import com.twilio.rest.updater.preview.wireless.DeviceUpdater;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device extends Resource {
    private static final long serialVersionUID = 71255259684453L;

    /**
     * Create a DeviceFetcher to execute fetch.
     * 
     * @param sid The sid
     * @return DeviceFetcher capable of executing the fetch
     */
    public static DeviceFetcher fetch(final String sid) {
        return new DeviceFetcher(sid);
    }

    /**
     * Create a DeviceReader to execute read.
     * 
     * @return DeviceReader capable of executing the read
     */
    public static DeviceReader read() {
        return new DeviceReader();
    }

    /**
     * Create a DeviceCreator to execute create.
     * 
     * @param ratePlan The rate_plan
     * @return DeviceCreator capable of executing the create
     */
    public static DeviceCreator create(final String ratePlan) {
        return new DeviceCreator(ratePlan);
    }

    /**
     * Create a DeviceUpdater to execute update.
     * 
     * @param sid The sid
     * @return DeviceUpdater capable of executing the update
     */
    public static DeviceUpdater update(final String sid) {
        return new DeviceUpdater(sid);
    }

    /**
     * Converts a JSON String into a Device object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Device object represented by the provided JSON
     */
    public static Device fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Device.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Device object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Device object represented by the provided JSON
     */
    public static Device fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Device.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String alias;
    private final String accountSid;
    private final String ratePlanSid;
    private final String friendlyName;
    private final String simIdentifier;
    private final String status;
    private final URI commandsCallbackUrl;
    private final String commandsCallbackMethod;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Device(@JsonProperty("sid")
                   final String sid, 
                   @JsonProperty("alias")
                   final String alias, 
                   @JsonProperty("account_sid")
                   final String accountSid, 
                   @JsonProperty("rate_plan_sid")
                   final String ratePlanSid, 
                   @JsonProperty("friendly_name")
                   final String friendlyName, 
                   @JsonProperty("sim_identifier")
                   final String simIdentifier, 
                   @JsonProperty("status")
                   final String status, 
                   @JsonProperty("commands_callback_url")
                   final URI commandsCallbackUrl, 
                   @JsonProperty("commands_callback_method")
                   final String commandsCallbackMethod, 
                   @JsonProperty("date_created")
                   final String dateCreated, 
                   @JsonProperty("date_updated")
                   final String dateUpdated, 
                   @JsonProperty("url")
                   final URI url, 
                   @JsonProperty("links")
                   final Map<String, String> links) {
        this.sid = sid;
        this.alias = alias;
        this.accountSid = accountSid;
        this.ratePlanSid = ratePlanSid;
        this.friendlyName = friendlyName;
        this.simIdentifier = simIdentifier;
        this.status = status;
        this.commandsCallbackUrl = commandsCallbackUrl;
        this.commandsCallbackMethod = commandsCallbackMethod;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
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
     * Returns The The alias.
     * 
     * @return The alias
     */
    public final String getAlias() {
        return this.alias;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The rate_plan_sid.
     * 
     * @return The rate_plan_sid
     */
    public final String getRatePlanSid() {
        return this.ratePlanSid;
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
     * Returns The The sim_identifier.
     * 
     * @return The sim_identifier
     */
    public final String getSimIdentifier() {
        return this.simIdentifier;
    }

    /**
     * Returns The The status.
     * 
     * @return The status
     */
    public final String getStatus() {
        return this.status;
    }

    /**
     * Returns The The commands_callback_url.
     * 
     * @return The commands_callback_url
     */
    public final URI getCommandsCallbackUrl() {
        return this.commandsCallbackUrl;
    }

    /**
     * Returns The The commands_callback_method.
     * 
     * @return The commands_callback_method
     */
    public final String getCommandsCallbackMethod() {
        return this.commandsCallbackMethod;
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

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Device other = (Device) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(alias, other.alias) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(ratePlanSid, other.ratePlanSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(simIdentifier, other.simIdentifier) && 
               Objects.equals(status, other.status) && 
               Objects.equals(commandsCallbackUrl, other.commandsCallbackUrl) && 
               Objects.equals(commandsCallbackMethod, other.commandsCallbackMethod) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            alias,
                            accountSid,
                            ratePlanSid,
                            friendlyName,
                            simIdentifier,
                            status,
                            commandsCallbackUrl,
                            commandsCallbackMethod,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("alias", alias)
                          .add("accountSid", accountSid)
                          .add("ratePlanSid", ratePlanSid)
                          .add("friendlyName", friendlyName)
                          .add("simIdentifier", simIdentifier)
                          .add("status", status)
                          .add("commandsCallbackUrl", commandsCallbackUrl)
                          .add("commandsCallbackMethod", commandsCallbackMethod)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}