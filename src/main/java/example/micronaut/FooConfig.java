package example.micronaut;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;
import io.micronaut.core.naming.conventions.StringConvention;

import java.util.Map;

@ConfigurationProperties("foo.config")
public class FooConfig {
  private final String fooBar;
  private final Map<String, String> barBlah;

  @ConfigurationInject
  public FooConfig(String fooBar,
    @MapFormat(transformation = MapFormat.MapTransformation.FLAT, keyFormat = StringConvention.RAW) Map<String, String> barBlah) {
    this.fooBar = fooBar;
    this.barBlah = barBlah;
  }

  public String getFooBar() {
    return fooBar;
  }

  public Map<String, String> getBarBlah() {
    return barBlah;
  }
}
