package com.mirage.geo;

/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.mirage.geo.GeociodingServiceGrpc.GeociodingServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class GeocodingServiceServer {

  private static final Logger logger = Logger.getLogger(GeocodingServiceServer.class.getName());

  static class GeocodingServiceImpl extends GeociodingServiceImplBase {
    @Override
    public void getGeocode(GetGeocodeRequest req,
        StreamObserver<GetGeocodeResponse> responseObserver) {
      System.err.println("Received request " + req);
      GetGeocodeResponse reply = GetGeocodeResponse.newBuilder()
          .setMessage("Hello " + req.getName()).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }
}
