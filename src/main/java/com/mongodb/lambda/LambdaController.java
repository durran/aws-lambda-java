package com.mongodb.lambda;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

public class LambdaController implements RequestHandler {
  static MongoClient client;
  static MongoDatabase database;
  static MongoCollection<Document> collection;

  static {
    client = MongoClients.create(System.getenv("MONGODB_URI"));
    database = client.getDatabase("test");
    collection = database.getCollection("test");
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
