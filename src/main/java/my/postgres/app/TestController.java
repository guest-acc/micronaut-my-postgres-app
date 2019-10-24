/*
 * Copyright (c) AppDynamics, Inc., and its affiliates
 * 2019
 * All Rights Reserved
 * THIS IS UNPUBLISHED PROPRIETARY CODE OF APPDYNAMICS, INC.
 * The copyright notice above does not evidence any actual or intended publication of such source code
 */

package my.postgres.app;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactiverse.reactivex.pgclient.PgPool;
import io.reactivex.Single;

import javax.inject.Inject;

@Controller("/")
public class TestController {

    @Inject
    PgPool client;

    @Get("/test")
    public Single<HttpResponse> test() {
        return client.rxQuery("select * from config")
                .map(rows -> HttpResponse.ok(rows.rowCount()));
    }
}
