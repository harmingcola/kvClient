package org.seekay.kv.client.pair

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class CreatePairSpec extends ClientBaseSpec {

    def 'a pair should be created and returned on the server'() {
        given:
            Pair pair = new Pair('name', 'create key value pair, test 0001')
        when:
            Pair createdPair = kvClient.create(pair)
        then:
            createdPair.key == 'name'
            createdPair.value == 'create key value pair, test 0001'
    }
}
