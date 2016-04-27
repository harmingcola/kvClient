package org.seekay.kv.client.pair

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class UpdatePairSpec extends ClientBaseSpec {

    def 'a pair should be updatable on the server'() {
        given:
            Pair pair = new Pair('height', '180')
        when:
            Pair updatedPair = kvClient.update(pair)
        then:
            updatedPair.key == 'height'
            updatedPair.value == '180'
    }
}
