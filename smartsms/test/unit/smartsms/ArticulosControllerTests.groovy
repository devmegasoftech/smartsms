package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(ArticulosController)
@Mock(Articulos)
class ArticulosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/articulos/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.articulosInstanceList.size() == 0
        assert model.articulosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.articulosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.articulosInstance != null
        assert view == '/articulos/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/articulos/show/1'
        assert controller.flash.message != null
        assert Articulos.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/articulos/list'

        populateValidParams(params)
        def articulos = new Articulos(params)

        assert articulos.save() != null

        params.id = articulos.id

        def model = controller.show()

        assert model.articulosInstance == articulos
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/articulos/list'

        populateValidParams(params)
        def articulos = new Articulos(params)

        assert articulos.save() != null

        params.id = articulos.id

        def model = controller.edit()

        assert model.articulosInstance == articulos
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/articulos/list'

        response.reset()

        populateValidParams(params)
        def articulos = new Articulos(params)

        assert articulos.save() != null

        // test invalid parameters in update
        params.id = articulos.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/articulos/edit"
        assert model.articulosInstance != null

        articulos.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/articulos/show/$articulos.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        articulos.clearErrors()

        populateValidParams(params)
        params.id = articulos.id
        params.version = -1
        controller.update()

        assert view == "/articulos/edit"
        assert model.articulosInstance != null
        assert model.articulosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/articulos/list'

        response.reset()

        populateValidParams(params)
        def articulos = new Articulos(params)

        assert articulos.save() != null
        assert Articulos.count() == 1

        params.id = articulos.id

        controller.delete()

        assert Articulos.count() == 0
        assert Articulos.get(articulos.id) == null
        assert response.redirectedUrl == '/articulos/list'
    }
}
