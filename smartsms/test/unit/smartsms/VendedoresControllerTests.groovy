package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(VendedoresController)
@Mock(Vendedores)
class VendedoresControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vendedores/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.vendedoresInstanceList.size() == 0
        assert model.vendedoresInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.vendedoresInstance != null
    }

    void testSave() {
        controller.save()

        assert model.vendedoresInstance != null
        assert view == '/vendedores/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vendedores/show/1'
        assert controller.flash.message != null
        assert Vendedores.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vendedores/list'

        populateValidParams(params)
        def vendedores = new Vendedores(params)

        assert vendedores.save() != null

        params.id = vendedores.id

        def model = controller.show()

        assert model.vendedoresInstance == vendedores
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vendedores/list'

        populateValidParams(params)
        def vendedores = new Vendedores(params)

        assert vendedores.save() != null

        params.id = vendedores.id

        def model = controller.edit()

        assert model.vendedoresInstance == vendedores
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vendedores/list'

        response.reset()

        populateValidParams(params)
        def vendedores = new Vendedores(params)

        assert vendedores.save() != null

        // test invalid parameters in update
        params.id = vendedores.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vendedores/edit"
        assert model.vendedoresInstance != null

        vendedores.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vendedores/show/$vendedores.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vendedores.clearErrors()

        populateValidParams(params)
        params.id = vendedores.id
        params.version = -1
        controller.update()

        assert view == "/vendedores/edit"
        assert model.vendedoresInstance != null
        assert model.vendedoresInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vendedores/list'

        response.reset()

        populateValidParams(params)
        def vendedores = new Vendedores(params)

        assert vendedores.save() != null
        assert Vendedores.count() == 1

        params.id = vendedores.id

        controller.delete()

        assert Vendedores.count() == 0
        assert Vendedores.get(vendedores.id) == null
        assert response.redirectedUrl == '/vendedores/list'
    }
}
