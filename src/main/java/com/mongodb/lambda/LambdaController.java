package com.mongodb.lambda;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

public class LambdaController implements RequestHandler {
  private MongoClient client;
  private MongoClientSettings settings;
  private MongoDatabase database;
  private MongoCollection<Document> collection;

  public LambdaController() {
    settings = MongoClientSettings
      .builder()
      .applicationName("AWS Lambda Java Driver Test")
      .applyConnectionString(new ConnectionString(System.getenv("MONGODB_URI")))
      .addCommandListener(new CommandLogger())
      .applyToServerSettings(builder ->
        builder.addServerMonitorListener(new ServerHeartbeatLogger()))
      .build();
    client = MongoClients.create(settings);
    database = client.getDatabase("test");
    collection = database.getCollection("test");
    database.runCommand(new Document("ping", 1));
  }

  @Override
  public String handleRequest(Object input, Context context) {
    Document doc = new Document("name", "test");
    InsertOneResult result = collection.insertOne(doc);
    Bson filter = Filters.eq("name", "test");
    collection.deleteOne(filter);
    return "Inserted/deleted document: " + result.getInsertedId().toString();
  }
}
