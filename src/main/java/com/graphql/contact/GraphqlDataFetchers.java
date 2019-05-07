package com.graphql.contact;


import com.google.common.collect.ImmutableMap;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import graphql.schema.DataFetcher;

@Component
public class GraphqlDataFetchers {

  private static List<Map<String, String>> contacts = Arrays.asList(
      ImmutableMap.of("id", "contact-1",
          "firstName", "Frank",
          "lastName", "Lu"),
      ImmutableMap.of("id", "contact-2",
          "firstName", "Xiao",
          "lastName", "Lu"),
      ImmutableMap.of("id", "contact-3",
          "firstName", "Zhecheng",
          "lastName", "Xiao")
  );


  public DataFetcher getContactByIdDataFetcher() {

    return dataFetchingEnvironment -> {
      String contactId = dataFetchingEnvironment.getArgument("id");
      return contacts
          .stream()
          .filter(contact -> contact.get("id").equals(contactId))
          .findFirst()
          .orElse(null);
    };
  }
}
