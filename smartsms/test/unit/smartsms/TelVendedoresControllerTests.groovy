package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(TelVendedoresController)
@Mock(TelVendedores)
class TelVendedoresControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/telVendedores/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.telVendedoresInstanceList.size() == 0
        assert model.telVendedoresInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.telVendedoresInstance != null
    }

    void testSave() {
        controller.save()

        assert model.telVendedoresInstance != null
        assert view == '/telVendedores/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/telVendedores/show/1'
        assert controller.flash.message != null
        assert TelVendedores.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/telVendedores/list'

        populateValidParams(params)
        def telVendedores = new TelVendedores(params)

        assert telVendedores.save() != null

        params.id = telVendedores.id

        def model = controller.show()

        assert model.telVendedoresInstance == telVendedores
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/telVendedores/list'

        populateValidParams(params)
        def telVendedores = new TelVendedores(params)

        assert telVendedores.save() != null

        params.id = telVendedores.id

        def model = controller.edit()

        assert model.telVendedoresInstance == telVendedores
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/telVendedores/list'

        response.reset()

        populateValidParams(params)
        def telVendedores = new TelVendedores(params)

        assert telVendedores.save() != null

        // test invalid parameters in update
        params.id = telVendedores.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/telVendedores/edit"
        assert model.telVendedoresInstance != null

        telVendedores.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/telVendedores/show/$telVendedores.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        telVendedores.clearErrors()

        populateValidParams(params)
        params.id = telVendedores.id
        params.version = -1
        controller.update()

        assert view == "/telVendedores/edit"
        assert model.telVendedoresInstance != null
        assert model.telVendedoresInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/telVendedores/list'

        response.reset()

        populateValidParams(params)
        def telVendedores = new TelVendedores(params)

        assert telVendedores.save() != null
        assert TelVendedores.count() == 1

        params.id = telVendedores.id

        controller.delete()

        assert TelVendedores.count() == 0
        assert TelVendedores.get(telVendedores.id) == null
        assert response.redirectedUrl == '/telVendedores/list'
    }
}
