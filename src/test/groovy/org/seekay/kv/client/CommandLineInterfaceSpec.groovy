package org.seekay.kv.client

import org.seekay.kv.client.cli.CommandLineInterface
import spock.lang.Specification

class CommandLineInterfaceSpec extends Specification {

    def 'No arguments should cause a problem' () {
        given:
            def args = [] as String[]
        when:
            CommandLineInterface.main(args)
        then:
            noExceptionThrown()
    }
}
