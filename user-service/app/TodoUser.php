<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class TodoUser extends Model
{


    /**
     * The table associated with the model.
     *
     * @var string
     */
    protected $table = 'todo_user';
    public $timestamps = false;
    protected $primaryKey = 'auth_user_id';

    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'first_name', 'last_name', 'auth_user_id'
    ];


    /**
     * The attributes excluded from the model's JSON form.
     *
     * @var array
     */
    protected $hidden = [];


    public function getFirstName(): string
    {
        return $this->first_name;
    }


    public function getAuthUserId(): int
    {
        return $this->auth_user_id;
    }

    public function getLastName(): string
    {
        return $this->last_name;
    }

    public function setFirstName(string $firstName): void
    {
        $this->first_name = $firstName;
    }

    public function setLastName(string $lastName): void
    {
        $this->last_name = $lastName;
    }
}
