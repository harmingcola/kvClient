package org.seekay.kv.client

import org.seekay.kv.client.model.Pair
import org.seekay.kv.client.util.ClientBaseSpec

class ReadPairSpec extends ClientBaseSpec {

	def 'a pair should be created and returned on the server'() {
		when:
			Pair createdPair = kvClient.read('weight')
		then:
			createdPair.key == 'weight'
			createdPair.value == '220'
	}
}
