package org.seekay.kv.client

import org.seekay.kv.client.util.ClientBaseSpec

class DeletePairSpec extends ClientBaseSpec {

    def 'a pair should be delete-able from the server'() {
        expect:
            kvClient.delete('blood-pressure') == true
    }
}
