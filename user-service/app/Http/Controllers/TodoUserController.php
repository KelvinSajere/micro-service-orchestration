<?php

namespace App\Http\Controllers;

use App\TodoUser;
use Illuminate\Database\Eloquent\ModelNotFoundException;
use Symfony\Component\HttpKernel\Exception\NotAcceptableHttpException;

class TodoUserController extends Controller
{
    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        //
    }

    public function getAllUsers()
    {
        return TodoUser::all();
    }

    public function createUser(TodoUser $user): TodoUser
    {
        $user->save();
        return $user;
    }

    public function getUserById(int $id): TodoUser
    {
        $user = TodoUser::find($id);
        if (!$user) {
            throw new ModelNotFoundException("User Not Found");
        }
        return  $user;
    }

    public function deleteUser(int $id): void
    {
        TodoUser::destroy($id);
    }

    public function updateUser(TodoUser $updated): TodoUser
    {
        if (!$updated->getAuthUserId()) {
            throw new NotAcceptableHttpException("missing Auth_User_ID");
        }
        $user = $this->getUserById($updated->getAuthUserId());
        $user->setFirstName($updated->getFirstName());
        $user->setLastName($updated->getLastName());
        return $this->createUser($user);
    }
}
