package org.seekay.kv.client.service

import org.seekay.kv.client.util.ClientBaseSpec

class RequestTimeSpec extends ClientBaseSpec {

    def "the client should retrieve the correct time from the server" () {
        when:
            long serverTime = kvClient.requestTime()
        then:
            serverTime > new Date().getTime() - 1000
            serverTime < new Date().getTime() + 1000
    }
}
