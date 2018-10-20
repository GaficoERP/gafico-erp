package sn.smart.eco.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.StringUtils;

public final class GaficoCommonUtils {

  public static String toJsonString(Object obj) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      // FIXME use Logger instead
      e.printStackTrace();
      return StringUtils.EMPTY;
    }
  }
}
