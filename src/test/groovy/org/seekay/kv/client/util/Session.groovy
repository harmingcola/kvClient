package org.seekay.kv.client.util

import org.seekay.contract.server.ContractServer

class Session {

    private static final ThreadLocal<Map<String, Object>> CONTEXT = new ThreadLocal<HashMap<String, Object>>()

    public static final String CONTRACT_SERVER = "contractServer"

    public void setContractServer(ContractServer items) {
        setKeyValue(CONTRACT_SERVER, items)
    }

    public ContractServer getContractServer() {
        return (ContractServer) getObjectByKey(CONTRACT_SERVER)
    }

    private Object getObjectByKey(String key) {
        Map<String, Object> map = CONTEXT.get()
        if(map == null) {
            return null
        }
        return map.get(key)
    }

    private void setKeyValue(String key, Object value) {
        Map<String, Object> map = CONTEXT.get()
        if(map == null) {
            map = new HashMap<String, Object>()
        }
        map.put(key, value)
        CONTEXT.set(map)
    }

}
