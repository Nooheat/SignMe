package com.nooheat.controller.responseless;

import com.nooheat.manager.JWT;
import com.nooheat.model.ResponselessLetter;
import com.nooheat.support.API;
import com.nooheat.support.Category;
import com.nooheat.support.URIMapping;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.RoutingContext;
import org.json.JSONArray;

/**
 * Created by NooHeat on 10/09/2017.
 */
@API(category = Category.TASK, summary = "비응답형 가정통신문 목록 조회", successCode = 200, failureCode = 400)
@URIMapping(uri = "/letter/responseless", method = HttpMethod.GET)
public class GetResponselessLetterList implements Handler<RoutingContext> {

    @Override
    public void handle(RoutingContext ctx) {
        HttpServerRequest req = ctx.request();
        HttpServerResponse res = ctx.response();

        JWT token = JWT.verify(ctx);
        if (token == null) {
            res.setStatusCode(401).end();
            return;
        }

        JsonArray response = ResponselessLetter.findAll();
        if (response != null) res.setStatusCode(200).end(response.toString());
        else res.setStatusCode(200).end(new JsonArray().toString());
    }
}
