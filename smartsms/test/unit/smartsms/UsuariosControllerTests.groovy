package smartsms



import org.junit.*
import grails.test.mixin.*

@TestFor(UsuariosController)
@Mock(Usuarios)
class UsuariosControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/usuarios/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.usuariosInstanceList.size() == 0
        assert model.usuariosInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.usuariosInstance != null
    }

    void testSave() {
        controller.save()

        assert model.usuariosInstance != null
        assert view == '/usuarios/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/usuarios/show/1'
        assert controller.flash.message != null
        assert Usuarios.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/usuarios/list'

        populateValidParams(params)
        def usuarios = new Usuarios(params)

        assert usuarios.save() != null

        params.id = usuarios.id

        def model = controller.show()

        assert model.usuariosInstance == usuarios
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/usuarios/list'

        populateValidParams(params)
        def usuarios = new Usuarios(params)

        assert usuarios.save() != null

        params.id = usuarios.id

        def model = controller.edit()

        assert model.usuariosInstance == usuarios
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/usuarios/list'

        response.reset()

        populateValidParams(params)
        def usuarios = new Usuarios(params)

        assert usuarios.save() != null

        // test invalid parameters in update
        params.id = usuarios.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/usuarios/edit"
        assert model.usuariosInstance != null

        usuarios.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/usuarios/show/$usuarios.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        usuarios.clearErrors()

        populateValidParams(params)
        params.id = usuarios.id
        params.version = -1
        controller.update()

        assert view == "/usuarios/edit"
        assert model.usuariosInstance != null
        assert model.usuariosInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/usuarios/list'

        response.reset()

        populateValidParams(params)
        def usuarios = new Usuarios(params)

        assert usuarios.save() != null
        assert Usuarios.count() == 1

        params.id = usuarios.id

        controller.delete()

        assert Usuarios.count() == 0
        assert Usuarios.get(usuarios.id) == null
        assert response.redirectedUrl == '/usuarios/list'
    }
}
