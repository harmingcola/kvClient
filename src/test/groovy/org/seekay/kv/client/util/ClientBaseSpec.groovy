package org.seekay.kv.client.util

import org.seekay.contract.server.ContractServer
import org.seekay.kv.client.KvClient
import spock.lang.Shared
import spock.lang.Specification

class ClientBaseSpec extends Specification {

    @Shared ContractServer server;

    @Shared KvClient client;

    @Shared Session session

    def setupSpec() {

        session = new Session()
        server = session.getContractServer()

        if(server == null) {
            server = ContractServer.newServer()
                    .onRandomPort()
                    .withGitConfig('https://github.com/harmingcola/kvContracts')
                    .startServer()

            session.setContractServer(server)
        }

        client = new KvClient(server.path() + '/kv')
    }
}
