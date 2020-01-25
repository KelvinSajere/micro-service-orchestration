<?php

use App\TodoUser;
use Illuminate\Http\Request;
use App\Http\Controllers\TodoUserController;

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It is a breeze. Simply tell Lumen the URIs it should respond to
| and give it the Closure to call when that URI is requested.
|
*/

$userController = new TodoUserController();

$router->get('/', function () use ($router) {
    return $router->app->version();
});

/* 
    Get Users
    Get user
    Create - User
    Delete - User
    Update - User : user role included


*/



$router->get('users', function () use ($userController) {

    return $userController->getAllUsers();
});

$router->get('user/{id}', function ($id) use ($userController) {
    return $userController->getUserById($id);
});

$router->post('user', function (Request $request) use ($userController) {
    $user = new TodoUser($request->all());
    return $userController->createuser($user);
});

$router->delete('user/{id}', function ($id) use ($userController) {
    return $userController->deleteUser($id);
});

$router->put('user', function (Request $request) use ($userController) {

    return $userController->updateUser(new TodoUser($request->all()));
});
