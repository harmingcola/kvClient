package org.seekay.kv.client

import org.seekay.contract.server.ContractServer
import spock.lang.Shared
import spock.lang.Specification

class UpdatePairSpec extends Specification {

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

    def 'a pair should be updatable on the server'() {
        given:
            Pair pair = new Pair( key:'height', value:'180')
        when:
            Pair updatedPair = client.update(pair)
        then:
            updatedPair.key == 'height'
            updatedPair.value == '180'
    }

}
