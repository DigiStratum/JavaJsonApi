package com.digistratum.JavaJsonApi;

import com.digistratum.JavaJson.Json;
import com.digistratum.JavaJson.JsonSerializeable;
import com.digistratum.JavaJsonApi.DynamicClass.Meta;

public class JsonApi implements JsonSerializeable {
	protected Properties properties;
	protected Json json;

	/**
	 * Default Constructor
	 */
	public JsonApi() {
		properties = new Properties();
	}

	/**
	 * Basic Constructor
	 *
	 * This one actually sets the version to the provided string.
	 * This is the most common use case and purpose of the class
	 *
	 * @param version String JsonApi version
	 */
	public JsonApi(String version) {
		this();
		properties.version = version;
	}

	/**
	 * A JSON serializable class with all our properties without exposing access
	 */
	protected class Properties {
		public String version;
		public Meta meta;
	}

	/**
	 * Set the JsonApi version
	 *
	 * TODO: What version of JsonApi specification do we support? (min is 1.0)
	 *
	 * @param version String version
	 *
	 * @return JsonApi (this) for chaining
	 */
	public JsonApi setVersion(String version) {
		properties.version = version;
		return this;
	}

	/**
	 * Set the JsonApi Metadata
	 *
	 * @param meta Meta instance with JsonApi metadata
	 *
	 * @return JsonApi (this) for chaining
	 */
	public JsonApi setMeta(Meta meta) {
		properties.meta = meta;
		return this;
	}

	@Override
	public String toJson() {
		if (null == json) json = new Json();
		// jsonBuilder.setVerbose(true);
		return json.toJson(properties);
	}
}
