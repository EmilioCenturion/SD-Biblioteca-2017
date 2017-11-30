import com.google.code.ssm.CacheFactory
import com.google.code.ssm.config.DefaultAddressProvider
import com.google.code.ssm.providers.CacheConfiguration
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl
import com.google.code.ssm.spring.SSMCache
import com.google.code.ssm.spring.SSMCacheManager
import login.MyAuthenticationProvider;

// Place your Spring DSL code here
beans = {
	myAuthenticationProvider(MyAuthenticationProvider) {
	}
	
}
