package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(TiposUsuariosController)
@Mock(TiposUsuarios)
class TiposUsuariosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tiposUsuarios/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tiposUsuariosInstanceList.size() == 0
        assert model.tiposUsuariosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tiposUsuariosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tiposUsuariosInstance != null
        assert view == '/tiposUsuarios/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tiposUsuarios/show/1'
        assert controller.flash.message != null
        assert TiposUsuarios.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tiposUsuarios/list'

        populateValidParams(params)
        def tiposUsuarios = new TiposUsuarios(params)

        assert tiposUsuarios.save() != null

        params.id = tiposUsuarios.id

        def model = controller.show()

        assert model.tiposUsuariosInstance == tiposUsuarios
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tiposUsuarios/list'

        populateValidParams(params)
        def tiposUsuarios = new TiposUsuarios(params)

        assert tiposUsuarios.save() != null

        params.id = tiposUsuarios.id

        def model = controller.edit()

        assert model.tiposUsuariosInstance == tiposUsuarios
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tiposUsuarios/list'

        response.reset()

        populateValidParams(params)
        def tiposUsuarios = new TiposUsuarios(params)

        assert tiposUsuarios.save() != null

        // test invalid parameters in update
        params.id = tiposUsuarios.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tiposUsuarios/edit"
        assert model.tiposUsuariosInstance != null

        tiposUsuarios.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tiposUsuarios/show/$tiposUsuarios.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tiposUsuarios.clearErrors()

        populateValidParams(params)
        params.id = tiposUsuarios.id
        params.version = -1
        controller.update()

        assert view == "/tiposUsuarios/edit"
        assert model.tiposUsuariosInstance != null
        assert model.tiposUsuariosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tiposUsuarios/list'

        response.reset()

        populateValidParams(params)
        def tiposUsuarios = new TiposUsuarios(params)

        assert tiposUsuarios.save() != null
        assert TiposUsuarios.count() == 1

        params.id = tiposUsuarios.id

        controller.delete()

        assert TiposUsuarios.count() == 0
        assert TiposUsuarios.get(tiposUsuarios.id) == null
        assert response.redirectedUrl == '/tiposUsuarios/list'
    }
}
