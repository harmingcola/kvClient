package org.seekay.kv.client

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class UpdatePairSpec extends ClientBaseSpec {

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
