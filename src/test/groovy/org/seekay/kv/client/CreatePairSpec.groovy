package org.seekay.kv.client

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class CreatePairSpec extends ClientBaseSpec {

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
