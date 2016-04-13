package org.seekay.kv.client

import org.seekay.contract.server.ContractServer
import spock.lang.Shared
import spock.lang.Specification

class CreatePairSpec extends Specification {

    @Shared
    ContractServer server;

    @Shared
    KvClient client;

    def setupSpec() {
        server = ContractServer.newServer()
                .onRandomPort()
                .withGitConfig('https://github.com/harmingcola/kvContracts')
                .startServer()

        client = new KvClient(server.path() + '/kv')
    }

    def 'a pair should be created and returned on the server'() {
        given:
            Pair pair = new Pair( key:'name', value:'create key value pair, test 0001')
        when:
            Pair createdPair = client.create(pair)
        then:
            createdPair.key == 'name'
            createdPair.value == 'create key value pair, test 0001'

    }

}
