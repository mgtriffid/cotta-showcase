package com.mgtriffid.games.cotta.showcase.server

import com.mgtriffid.games.cotta.server.guice.CottaServerFactory
import com.mgtriffid.games.cotta.showcase.ShowcaseGame

class ShowcaseServer {
    fun start() {
        CottaServerFactory()
            .create(ShowcaseGame())
            .initializeInstances()
    }
}
