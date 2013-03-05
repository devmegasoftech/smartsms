package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(SupervisorVendedoresController)
@Mock(SupervisorVendedores)
class SupervisorVendedoresControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/supervisorVendedores/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.supervisorVendedoresInstanceList.size() == 0
        assert model.supervisorVendedoresInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.supervisorVendedoresInstance != null
    }

    void testSave() {
        controller.save()

        assert model.supervisorVendedoresInstance != null
        assert view == '/supervisorVendedores/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/supervisorVendedores/show/1'
        assert controller.flash.message != null
        assert SupervisorVendedores.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorVendedores/list'

        populateValidParams(params)
        def supervisorVendedores = new SupervisorVendedores(params)

        assert supervisorVendedores.save() != null

        params.id = supervisorVendedores.id

        def model = controller.show()

        assert model.supervisorVendedoresInstance == supervisorVendedores
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorVendedores/list'

        populateValidParams(params)
        def supervisorVendedores = new SupervisorVendedores(params)

        assert supervisorVendedores.save() != null

        params.id = supervisorVendedores.id

        def model = controller.edit()

        assert model.supervisorVendedoresInstance == supervisorVendedores
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/supervisorVendedores/list'

        response.reset()

        populateValidParams(params)
        def supervisorVendedores = new SupervisorVendedores(params)

        assert supervisorVendedores.save() != null

        // test invalid parameters in update
        params.id = supervisorVendedores.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/supervisorVendedores/edit"
        assert model.supervisorVendedoresInstance != null

        supervisorVendedores.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/supervisorVendedores/show/$supervisorVendedores.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        supervisorVendedores.clearErrors()

        populateValidParams(params)
        params.id = supervisorVendedores.id
        params.version = -1
        controller.update()

        assert view == "/supervisorVendedores/edit"
        assert model.supervisorVendedoresInstance != null
        assert model.supervisorVendedoresInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/supervisorVendedores/list'

        response.reset()

        populateValidParams(params)
        def supervisorVendedores = new SupervisorVendedores(params)

        assert supervisorVendedores.save() != null
        assert SupervisorVendedores.count() == 1

        params.id = supervisorVendedores.id

        controller.delete()

        assert SupervisorVendedores.count() == 0
        assert SupervisorVendedores.get(supervisorVendedores.id) == null
        assert response.redirectedUrl == '/supervisorVendedores/list'
    }
}
