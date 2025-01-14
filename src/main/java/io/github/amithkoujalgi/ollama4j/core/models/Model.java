package io.github.amithkoujalgi.ollama4j.core.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.amithkoujalgi.ollama4j.core.utils.Utils;
import lombok.Data;

@Data
public class Model {

  private String name;
  private String model;
  @JsonProperty("modified_at")
  private LocalDateTime modifiedAt;
  @JsonProperty("expires_at")
  private LocalDateTime expiresAt;
  private String digest;
  private long size;
  @JsonProperty("details")
  private ModelMeta modelMeta;


  /**
   * Returns the model name without its version
   *
   * @return model name
   */
  public String getModelName() {
    return name.split(":")[0];
  }

  /**
   * Returns the model version without its name
   *
   * @return model version
   */
  public String getModelVersion() {
    return name.split(":")[1];
  }

    @Override
  public String toString() {
    try {
      return Utils.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
