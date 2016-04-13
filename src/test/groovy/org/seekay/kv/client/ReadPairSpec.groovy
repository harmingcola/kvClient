package org.seekay.kv.client

import org.seekay.contract.server.ContractServer
import spock.lang.Shared
import spock.lang.Specification

class ReadPairSpec extends Specification {

	@Shared
	ContractServer server

	@Shared
	KvClient client

	def setupSpec() {
		server = ContractServer.newServer()
				.onRandomPort()
				.withGitConfig('https://github.com/harmingcola/kvContracts')
				.startServer()

		client = new KvClient(server.path() + '/kv')
	}

	def 'a pair should be created and returned on the server'() {
		when:
			Pair createdPair = client.read('weight')
		then:
			createdPair.key == 'weight'
			createdPair.value == '220'

	}

}
