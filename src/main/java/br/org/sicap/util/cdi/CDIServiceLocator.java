package br.org.sicap.util.cdi;

import br.org.sicap.excecoes.SICAPException;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CDIServiceLocator {

    private static final Log LOGGER = LogFactory.getLog(CDIServiceLocator.class);

    private CDIServiceLocator() {
    }

    private static BeanManager getBeanManager() throws SICAPException {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            LOGGER.error(e);
            throw new SICAPException("Não pôde encontrar BeanManager no JNDI.");
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) throws SICAPException {
        BeanManager bm = getBeanManager();
        Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(clazz);

        if (beans == null || beans.isEmpty()) {
            return null;
        }

        Bean<T> bean = (Bean<T>) beans.iterator().next();

        CreationalContext<T> ctx = bm.createCreationalContext(bean);

        return (T) bm.getReference(bean, clazz, ctx);
    }

}
