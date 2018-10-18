import javax.servlet.http.HttpServletResponse


class CacheFilters{

    def filters = {
        all(controller: '*', action: '*') {
            before = {
                ((HttpServletResponse) response).setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            }
            after = {

            }
            afterView = {

            }
        }
    }

}