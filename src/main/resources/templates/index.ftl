<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<h2>Save Category</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>

    <form action="/save" method="post">
        <tr>
            <td>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="name">
            </td>
            <td>
                <label for="description">Description</label>
                <input type="text" id="description" name="description" placeholder="description">
            </td>
            <td>
                <label for="image">Image</label>
                <input type="text" id="image" name="image" placeholder="link">
            </td>
        </tr>
        <tr>
            <td>

            </td>
            <td>
                <input type="submit" value="add">
            </td>
        </tr>
    </form>

    </tbody>

</table>

<h2>List of Categories</h2>
<ul>
    <#if categories??>
        <#list categories as category>
            <li>
                <a href="/${category.id}">${category.name}</a>
            </li>
        </#list>
    </#if>
</ul>

<h2>Update/Delete Category</h2>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>image</th>
    </tr>
    </thead>
    <tbody>
    <#if categories??>
        <#list categories as category>
            <form action="/update" method="post">
                <tr>
                    <td>
                        <input type="hidden" name="id" value="${category.id}">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="${category.name}">
                    </td>
                    <td>
                        <label for="description">Description</label>
                        <input type="text" id="description" name="description" value="${category.description}">
                    </td>
                    <td>
                        <label for="image">Image</label>
                        <input type="text" id="image" name="image" value="${category.image}">
                    </td>
                    <td>
                        <button type="submit">update</button>
                    </td>

            </form>
            <form action="/delete" method="post">
                <input type="hidden" name="id" value="${category.id}">
                <td>
                    <input type="submit" value="delete">
                </td>
            </form>

            </tr>
        </#list>
    </#if>
    </tbody>
</table>

<h2> Delete Category</h2>


<form action="/delete" method="post">
    <select name="id">
        <#if categories??>
            <#list categories as category>
                <li>
                    <option value="${category.id}">${category.name}</option>
                </li>
            </#list>
        </#if>
    </select>
    <button type="submit">delete</button>
</form>



        <a href="/rate"> GO TO RATES </a>


</body>
</html>