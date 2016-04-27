package org.seekay.kv.client.pair

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class SearchKeySpec extends ClientBaseSpec {

    def "when a search request is made, the correct results should be returned" () {
        when:
            List<Pair> searchResults = kvClient.search("weight")
        then:
            searchResults.size() == 2
    }
}
