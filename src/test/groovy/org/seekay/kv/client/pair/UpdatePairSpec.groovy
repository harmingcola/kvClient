package org.seekay.kv.client.pair

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class UpdatePairSpec extends ClientBaseSpec {

    def 'a pair should be updatable on the server'() {
        given:
            Pair pair = new Pair('height-json', '100')
            pair = kvClient.create(pair);
        when:
            pair.setValue('180')
            pair = kvClient.update(pair)
        then:
            pair.key == 'height-json'
            pair.value == '180'
    }
}
