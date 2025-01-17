package nextflow.trace

import groovy.transform.CompileStatic
import nextflow.Session

/**
 * Factory logic for WebLog observer
 *
 * @author Paolo Di Tommaso <paolo.ditommaso@gmail.com>
 */
@CompileStatic
class WebLogFactory implements TraceObserverFactory {

    @Override
    Collection<TraceObserver> create(Session session) {
        def isEnabled = session.config.navigate('weblog.enabled') as Boolean
        def url = session.config.navigate('weblog.url') as String
        def result = new ArrayList()
        if ( isEnabled ) {
            if ( !url ) url = WebLogObserver.DEF_URL
            def observer = new WebLogObserver(url)
            result << observer
        }
        return result
    }

}
