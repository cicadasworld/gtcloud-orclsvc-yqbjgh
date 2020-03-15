package gtcloud.yqbjgh.bootstrap

import gtcloud.yqbjgh.services.TxzhTsBddwmlService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private RootIdsBean rootIdsBean

    private BddwmlNodeBean bddwmlNodeBean

    @Autowired
    private TxzhTsBddwmlService service

    @Autowired
    ContextRefreshedListener(BddwmlNodeBean bddwmlNodeBean, RootIdsBean rootIdsBean) {
        this.rootIdsBean = rootIdsBean
        this.bddwmlNodeBean = bddwmlNodeBean
    }

    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {
        rootIdsBean.rootIds = service.getRootIds()
        bddwmlNodeBean.rootToNodes = service.getUsingTreeMap()
    }
}
